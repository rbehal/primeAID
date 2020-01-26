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

def diagnosis(symptoms):
    global data
    url = "https://priaid-symptom-checker-v1.p.rapidapi.com/diagnosis"

    querystring = {"symptoms":symptoms,"gender":"male","year_of_birth":"1984","language":"en-gb"}

    headers = {
        'x-rapidapi-host': "priaid-symptom-checker-v1.p.rapidapi.com",
        'x-rapidapi-key': "0a97cf38bbmsh7fc6f0db2001126p1328e6jsn973f4bb67542"
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
        return response   


@app.route('/', methods = ['POST'])
@cross_origin()
def school():
    # resp = flask.Response("Foo bar baz")
    # resp.headers['Access-Control-Allow-Origin'] = '*'
    if(request.method == 'POST'):
        testArr = request.json['obj']
        diagnosis(str(testArr))
        return jsonify(testArr)


# driver function 
if __name__ == '__main__': 
    app.run(debug = True) 

