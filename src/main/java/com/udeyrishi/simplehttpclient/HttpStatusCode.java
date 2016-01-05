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

/**
 * Major HTTP response status codes.
 * Created by rishi on 15-10-31.
 */
public enum HttpStatusCode {
    OK(200),
    CREATED(201),
    NO_CONTENT(204),
    BAD_REQUEST(400),
    NOT_FOUND(404);

    private int statusCode;

    HttpStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    /**
     * Checks if the passed int status code corresponds to an error code or not.
     *
     * @param errorCode The error code to be checked.
     * @return True, if the code corresponds to an error code.
     */
    public static boolean isErrorCode(int errorCode) {
        return errorCode >= 400;
    }

    /**
     * Returns the int status code for the HTTP status code.
     *
     * @return The integer associated to the HTTP status code.
     */
    public int getStatusCode() {
        return statusCode;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return String.format("%d", statusCode);
    }

    /**
     * Checks if this {@link HttpStatusCode} corresponds to an error code or not.
     *
     * @return True, if the code corresponds to an error code.
     */
    public boolean isErrorCode() {
        return isErrorCode(this.getStatusCode());
    }

}
