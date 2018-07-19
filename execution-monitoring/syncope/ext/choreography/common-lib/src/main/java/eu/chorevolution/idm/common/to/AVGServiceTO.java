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
package eu.chorevolution.idm.common.to;

import org.apache.syncope.common.lib.AbstractBaseBean;

public class AVGServiceTO extends AbstractBaseBean {

    private static final long serialVersionUID = -1247350843534982560L;

    private String name;

    private int minExecutedOperations;

    private int maxExecutedOperations;

    private double executionTime;

    private double waitTimeForResponse;


    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public int getMinExecutedOperations() {
        return minExecutedOperations;
    }

    public void setMinExecutedOperations(final int minExecutedOperations) {
        this.minExecutedOperations = minExecutedOperations;
    }

    public int getMaxExecutedOperations() {
        return maxExecutedOperations;
    }

    public void setMaxExecutedOperations(final int maxExecutedOperations) {
        this.maxExecutedOperations = maxExecutedOperations;
    }

    public double getExecutionTime() {
        return executionTime;
    }

    public void setExecutionTime(final double executionTime) {
        this.executionTime = executionTime;
    }

    public double getWaitTimeForResponse() {
        return waitTimeForResponse;
    }

    public void setWaitTimeForResponse(final double waitTimeForResponse) {
        this.waitTimeForResponse = waitTimeForResponse;
    }
}
