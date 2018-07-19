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
package org.apache.syncope.client.console.pages;

import de.agilecoders.wicket.core.markup.html.bootstrap.tabs.AjaxBootstrapTabbedPanel;
import eu.chorevolution.idm.common.to.ChoreographyInstanceTO;
import java.util.ArrayList;
import java.util.List;
import org.apache.syncope.client.console.BookmarkablePageLinkBuilder;
import org.apache.syncope.client.console.panels.CDPanel;
import org.apache.syncope.client.console.panels.InstanceChartsPanel;
import org.apache.syncope.client.console.panels.InstanceTimelinePanel;
import org.apache.syncope.client.console.panels.ServiceDirectoryPanel;
import org.apache.syncope.client.console.rest.ChoreographyRestClient;
import org.apache.wicket.extensions.markup.html.tabs.AbstractTab;
import org.apache.wicket.extensions.markup.html.tabs.ITab;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.ResourceModel;
import org.apache.wicket.request.mapper.parameter.PageParameters;

public class InstanceStatsPage extends BaseExtPage {

    private static final long serialVersionUID = 3932245590233237182L;

    public static final String PREF_STATS_PAGINATOR_ROWS = "stats.paginator.rows";

    private final ChoreographyRestClient restClient;

    private final String instanceId;

    private final ChoreographyInstanceTO choreographyInstance;

    public InstanceStatsPage(final PageParameters parameters) {
        super(parameters);

        restClient = new ChoreographyRestClient();
        instanceId = parameters.get("instance").toString();
        choreographyInstance = restClient.getChoreographyInstance(instanceId);

        // Set title
        body.add(new Label("header",
                getString("header_title") + " " + choreographyInstance.getChoreographyInstanceId()
                + " of " + choreographyInstance.getChoreographyName()));


        body.add(BookmarkablePageLinkBuilder.build("dashboard", "dashboardBr", Dashboard.class));
        body.add(BookmarkablePageLinkBuilder.build("choreographyBr", ChoreographyPage.class));

        PageParameters choreographyParams = new PageParameters();
        choreographyParams.add("chor", choreographyInstance.getChoreographyId());
        body.add(new BookmarkablePageLink("choreographyDetailsBr", ChoreographyDetailPage.class, choreographyParams)
                        .add(new Label("choreographyTitle", choreographyInstance.getChoreographyName())));

        body.add(new Label("instanceTitle", "Instance " + choreographyInstance.getChoreographyInstanceId()));

        WebMarkupContainer content = new WebMarkupContainer("content");
        content.setOutputMarkupId(true);

        content.add(new AjaxBootstrapTabbedPanel<>("detailsTab", buildTabList()));
        // Re-enable when entilements for this service will be defined
        //MetaDataRoleAuthorizationStrategy.authorize(content, ENABLE, CamelEntitlement.ROUTE_LIST);
        body.add(content);
    }

    private List<ITab> buildTabList() {
        final List<ITab> tabs = new ArrayList<>();

        tabs.add(new AbstractTab(new ResourceModel("overview")) {

            private static final long serialVersionUID = -6815067322125799251L;

            @Override
            public Panel getPanel(final String panelId) {
                return new InstanceChartsPanel(panelId, choreographyInstance);
            }
        });

        tabs.add(new AbstractTab(new ResourceModel("timeline")) {

            private static final long serialVersionUID = -6815067322125799251L;

            @Override
            public Panel getPanel(final String panelId) {
                return new InstanceTimelinePanel(panelId, instanceId);
            }
        });

        tabs.add(new AbstractTab(new ResourceModel("cds")) {

            private static final long serialVersionUID = -5274130621395293531L;

            @Override
            public Panel getPanel(final String panelId) {
                return new CDPanel(panelId, getPageReference(), instanceId);
            }
        });

        tabs.add(new AbstractTab(new ResourceModel("services")) {

            private static final long serialVersionUID = -5274130621395293531L;

            @Override
            public Panel getPanel(final String panelId) {
                return new ServiceDirectoryPanel(panelId, getPageReference(), instanceId);
            }
        });

        return tabs;
    }
}
