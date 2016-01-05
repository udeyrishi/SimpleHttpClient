/**
 Copyright 2016 Udey Rishi
 Licensed under the Apache License, Version 2.0 (the "License");
 you may not use this file except in compliance with the License.
 You may obtain a copy of the License at
 http://www.apache.org/licenses/LICENSE-2.0
 Unless required by applicable law or agreed to in writing, software
 distributed under the License is distributed on an "AS IS" BASIS,
 WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 See the License for the specific language governing permissions and
 limitations under the License.
 */

package com.udeyrishi.simplehttpclient;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * A simple HTTP client for performing requests with major HTTP verbs.
 * Created by rishi on 15-10-31.
 */
// Source: http://www.mkyong.com/java/how-to-send-http-request-getpost-in-java/
// Date: 31-Oct-2015
public class HttpClient {

    private URL root;

    /**
     * Creates an instance of {@link HttpClient}.
     *
     * @param root The root URL to be used for the requests.
     * @throws MalformedURLException Thrown, if the root URL is malformed.
     */
    public HttpClient(String root) throws MalformedURLException {
        this(new URL(root));
    }

    /**
     * Creates an instance of {@link HttpClient}/
     *
     * @param root The root {@link URL} for the requests.
     */
    public HttpClient(URL root) {
        this.root = root;
    }

    /**
     * Performs an HTTP GET request at the URL formed using the provided suffix appended to the root.
     *
     * @param suffix The suffix to be appended to the root URL.
     * @return The received {@link HttpResponse}.
     * @throws IOException Thrown, if the network connection fails.
     */
    public HttpResponse makeGetRequest(String suffix) throws IOException {
        return makeDataLessRequest(suffix, HttpMethods.GET);
    }

    /**
     * Performs an HTTP DELETE request at the URL formed using the provided suffix appended to the root.
     *
     * @param suffix The suffix to be appended to the root URL.
     * @return The received {@link HttpResponse}.
     * @throws IOException Thrown, if the network connection fails.
     */
    public HttpResponse makeDeleteRequest(String suffix) throws IOException {
        return makeDataLessRequest(suffix, HttpMethods.DELETE);
    }

    /**
     * Performs an HTTP POST request at the URL formed using the provided suffix appended to the root.
     *
     * @param suffix   The suffix to be appended to the root URL.
     * @param postData The byte array to be sent as the contents of the request.
     * @return The received {@link HttpResponse}.
     * @throws IOException Thrown, if the network connection fails.
     */
    public HttpResponse makePostRequest(String suffix, byte[] postData) throws IOException {
        return makeSendDataRequest(suffix, postData, HttpMethods.POST);
    }

    /**
     * Performs an HTTP PUT request at the URL formed using the provided suffix appended to the root.
     *
     * @param suffix  The suffix to be appended to the root URL.
     * @param putData The byte array to be sent as the contents of the request.
     * @return The received {@link HttpResponse}.
     * @throws IOException Thrown, if the network connection fails.
     */
    public HttpResponse makePutRequest(String suffix, byte[] putData) throws IOException {
        return makeSendDataRequest(suffix, putData, HttpMethods.PUT);
    }

    private HttpResponse makeDataLessRequest(String suffix, HttpMethods method) throws IOException {
        HttpURLConnection httpConnection = openHttpURLConnection(suffix);
        method.setMethod(httpConnection);
        httpConnection.setDoInput(true);

        HttpResponse response = new HttpResponse();
        response.readFromHttpURLConnection(httpConnection);
        httpConnection.disconnect();

        return response;
    }

    private HttpResponse makeSendDataRequest(String suffix, byte[] dataToBeSent, HttpMethods sendMethod) throws IOException {
        HttpURLConnection httpConnection = openHttpURLConnection(suffix);
        sendMethod.setMethod(httpConnection);
        httpConnection.setDoOutput(true);
        httpConnection.setDoInput(true);

        DataOutputStream out = new DataOutputStream(httpConnection.getOutputStream());
        out.write(dataToBeSent);
        out.flush();
        out.close();

        HttpResponse response = new HttpResponse();
        response.readFromHttpURLConnection(httpConnection);
        httpConnection.disconnect();

        return response;
    }

    private HttpURLConnection openHttpURLConnection(String suffix) throws IOException {
        URL queryUrl = new URL(root, suffix);
        return (HttpURLConnection) queryUrl.openConnection();
    }
}