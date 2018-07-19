/*
 * Copyright 2016 The CHOReVOLUTION project.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package eu.chorevolution.idm.common;

import java.util.HashSet;
import java.util.Set;

public class BusinessException extends RuntimeException {
    public BusinessException() {
        super();
    }

    public BusinessException(final String message, final Throwable cause) {
        super(message, cause);
    }

    public BusinessException(final String message) {
        super(message);
    }

    public BusinessException(final String message, final Set<String> errors, final Throwable cause) {
        super(message, cause);
        this.errors = errors;
    }

    public BusinessException(final String message, final Set<String> errors) {
        super(message);
        this.errors = errors;
    }

    public BusinessException(final Throwable cause) {
        super(cause);
    }

    private Set<String> errors = new HashSet<String>();

    public Set<String> getErrors() {
        return errors;
    }
}
