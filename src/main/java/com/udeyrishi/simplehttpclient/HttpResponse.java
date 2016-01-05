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

import org.apache.commons.io.IOUtils;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;

/**
 * A class modelling the response to an HTTP request.
 * Created by rishi on 15-10-31.
 */
public class HttpResponse {

    private int responseCode;
    private byte[] contents;

    /**
     * Creates an instance of {@link HttpResponse}/
     *
     * @param responseCode The response's status code.
     * @param contents     The contents of the response. Can be null if the response had no contents.
     */
    public HttpResponse(int responseCode, byte[] contents) {
        this.responseCode = responseCode;
        this.contents = contents;
    }

    /**
     * Creates an empty {@link HttpResponse} object with null contents and "-1" (invalid) status code.
     */
    public HttpResponse() {
        this(-1, null);
    }

    /**
     * Reads the {@link HttpResponse} data from an {@link HttpURLConnection}.
     *
     * @param httpConnection The {@link HttpURLConnection} from which the response is to be read.
     * @throws IOException Thrown, if the network connection fails.
     */
    public void readFromHttpURLConnection(HttpURLConnection httpConnection) throws IOException {
        responseCode = httpConnection.getResponseCode();

        InputStream in;
        if (HttpStatusCode.isErrorCode(responseCode)) {
            in = new BufferedInputStream(httpConnection.getErrorStream());
        } else {
            in = new BufferedInputStream(httpConnection.getInputStream());
        }

        contents = IOUtils.toByteArray(in);
        in.close();

    }

    /**
     * Getter for the response contents.
     *
     * @return Returns the byte array of the response's contents.
     */
    public byte[] getContents() {
        return contents;
    }

    /**
     * Getter for the response's status code.
     *
     * @return Returns the response's status code.
     */
    public int getResponseCode() {
        return responseCode;
    }

}
