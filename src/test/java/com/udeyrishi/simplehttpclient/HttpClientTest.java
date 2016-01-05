/**
 Copyright 2015 Udey Rishi
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

import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.net.MalformedURLException;

/**
 * Created by rishi on 2016-01-04.
 */
public class HttpClientTest {
    private HttpClient client;

    public HttpClientTest() throws MalformedURLException {
        client = new HttpClient("http://jsonplaceholder.typicode.com");
    }

    @Test
    public void testMakeGetRequest() throws IOException {
        HttpResponse response = client.makeGetRequest("posts/1");
        Assert.assertTrue(response.getResponseCode() == HttpStatusCode.OK.getStatusCode());
        String responseContents = new String(response.getContents());

        Assert.assertNotNull(responseContents);
        Assert.assertFalse(responseContents.trim().equals(""));
    }

    @Test
    public void testMakePutRequest() throws IOException {
        HttpResponse response = client.makePutRequest("posts/1", "{ 'foo' : 'bar' }".getBytes());
        Assert.assertTrue(response.getResponseCode() == HttpStatusCode.OK.getStatusCode());
        String responseContents = new String(response.getContents());
        Assert.assertNotNull(responseContents);
        Assert.assertFalse(responseContents.trim().equals(""));
    }

    @Test
    public void testMakePostRequest() throws IOException {
        HttpResponse response = client.makePostRequest("posts", "{ 'foo' : 'bar' }".getBytes());
        Assert.assertTrue(response.getResponseCode() == HttpStatusCode.CREATED.getStatusCode());
        String responseContents = new String(response.getContents());
        Assert.assertNotNull(responseContents);
        Assert.assertFalse(responseContents.trim().equals(""));
    }

    @Test
    public void testMakeDeleteRequest() throws IOException {
        HttpResponse response = client.makeDeleteRequest("posts/1");
        Assert.assertTrue(response.getResponseCode() == HttpStatusCode.OK.getStatusCode());
        String responseContents = new String(response.getContents());
        Assert.assertNotNull(responseContents);
        Assert.assertFalse(responseContents.trim().equals(""));
    }

    @Test
    public void testMakeNotFoundResponseRequest() throws IOException {
        HttpResponse response = client.makePutRequest("posts", "{ 'foo' : 'bar' }".getBytes());
        Assert.assertTrue(response.getResponseCode() == HttpStatusCode.NOT_FOUND.getStatusCode());
        String responseContents = new String(response.getContents());
        Assert.assertNotNull(responseContents);
        Assert.assertFalse(responseContents.trim().equals(""));
    }
}