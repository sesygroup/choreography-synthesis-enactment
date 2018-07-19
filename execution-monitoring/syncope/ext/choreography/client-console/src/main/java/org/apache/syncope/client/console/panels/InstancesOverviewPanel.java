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
package org.apache.syncope.client.console.panels;

import org.apache.syncope.client.console.pages.AVGInstanceStatsPage;
import org.apache.syncope.client.console.rest.ChoreographyRestClient;
import org.apache.wicket.PageReference;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.extensions.ajax.markup.html.IndicatingAjaxLink;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.request.mapper.parameter.PageParameters;

public class InstancesOverviewPanel extends Panel {

    public InstancesOverviewPanel(final String id,
            final PageReference pageReference,
            final ChoreographyRestClient restClient,
            final String choreographyId) {
        super(id);

        super.add(new InstanceDirectoryPanel("instances", pageReference, choreographyId));

        Double averageInstanceExecutionTime = restClient.getAverageInstanceExecutionTime(choreographyId);
        super.add(new Label("avg_instances", getString("average") + ": "
                + averageInstanceExecutionTime + " ms"));

        ChoreographyActionsPanel averageDetailsLink = new ChoreographyActionsPanel("avg_details");
        averageDetailsLink.addAction(new IndicatingAjaxLink<Void>("link") {

            private static final long serialVersionUID = -7978723352517770644L;

            @Override
            public void onClick(final AjaxRequestTarget request) {
                PageParameters parameters = new PageParameters();
                parameters.add("chor", choreographyId);
                setResponsePage(AVGInstanceStatsPage.class, parameters);
            }
        }, ChoreographyActionsPanel.ChoreographyActionType.SHOW);
        super.add(averageDetailsLink);
    }

}
