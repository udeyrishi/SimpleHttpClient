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

import java.net.HttpURLConnection;
import java.net.ProtocolException;


/**
 * Major HTTP methods/verbs.
 * Created by rishi on 15-10-31.
 */
public enum HttpMethods {
    GET("GET"), PUT("PUT"), POST("POST"), DELETE("DELETE");

    private final String methodName;

    HttpMethods(String methodName) {
        this.methodName = methodName;
    }

    /**
     * Returns the name of the HTTP Method.
     */
    @Override
    public String toString() {
        return methodName;
    }

    /**
     * Sets a {@link HttpURLConnection} to use the HTTP method.
     *
     * @param connection The {@link HttpURLConnection} object to be modified.
     */
    public void setMethod(HttpURLConnection connection) {
        try {
            connection.setRequestMethod(methodName);
        } catch (ProtocolException e) {
            throw new RuntimeException(String.format("Dev note: Typo in the HttpMethod '%s'", methodName), e);
        }
    }
}