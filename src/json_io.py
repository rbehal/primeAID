# Using flask to make an api 
# import necessary libraries and functions 
import flask
import requests
from flask import Flask, jsonify, request
from flask_restful import Api, Resource, reqparse
from flask_cors import CORS, cross_origin
import json

# creating a Flask app 
app = Flask(__name__) 
cors = CORS(app)
app.config['CORS_HEADERS'] = 'Content-Type'

data = []

def adjustHeaders(response, method):
    response.headers.add('Access-Control-Allow-Origin', '*')
    response.headers.add('Access-Control-Allow-Methods', method)

def severity(symptom):

    url = "https://priaid-symptom-checker-v1.p.rapidapi.com/redflag"

    querystring = {"symptomId":symptom,"language":"en-gb"}

    headers = {
        'x-rapidapi-host': "priaid-symptom-checker-v1.p.rapidapi.com",
        'x-rapidapi-key': "ba2d845ec6msh7461083374f07a2p1b52bfjsnf1cab3e7786e"
        }

    response = requests.request("GET", url, headers=headers, params=querystring)

    return response

def diagnosis(symptoms):
    global data
    url = "https://priaid-symptom-checker-v1.p.rapidapi.com/diagnosis"

    querystring = {"symptoms":str(symptoms),"gender":"male","year_of_birth":"1984","language":"en-gb"}

    headers = {
        'x-rapidapi-host': "priaid-symptom-checker-v1.p.rapidapi.com",
        'x-rapidapi-key': "ba2d845ec6msh7461083374f07a2p1b52bfjsnf1cab3e7786e"
        }

    response = requests.request("GET", url, headers=headers, params=querystring)
    response_json = response.json()
    n = len(response_json)

    issues = []

    for i in range(0, n):
        top_issues = response_json[i]['Issue']['Name']
        accuracy = response_json[i]['Issue']['Accuracy']
        if (accuracy > 65):
            issues.append(top_issues)

    severe_issues = []

    for i in symptoms:
        response = severity(str(i))
        response_msg = response.json()
        if (response_msg == ""):
            continue; 
        else:
            msg = "Recommendation based on diagnosis: Please go to an Emergency Room ASAP."
            issues.append(msg)
            severe_issues.append(msg)
            break;
    
    if (len(severe_issues) == 0):
        issues.append("Recommendation based on diagnosis: Please see a walk-in clinic.")

    data = issues
    return issues



@app.route('/', methods = ['GET']) 
def home(): 
    global data
    if(request.method == 'GET'): 
        try:
            response = flask.make_response(json.dumps(data), 200)
        except KeyError:
            response = flask.make_response("null", 404)
        adjustHeaders(response, 'GET')
        print('Test-GET', data)
        return response   


@app.route('/', methods = ['POST'])
@cross_origin()
def school():
    if(request.method == 'POST'):
        symptArr = request.json['obj'] # Integer Array
        diagnosis(symptArr)
        print('Test-POST', str(symptArr))
        return jsonify(symptArr)


# driver function 
if __name__ == '__main__': 
    app.run(debug = True) 

