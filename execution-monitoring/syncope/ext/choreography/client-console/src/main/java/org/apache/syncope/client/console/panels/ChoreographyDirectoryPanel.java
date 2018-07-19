/*
 * Copyright 2016 The CHOReVOLUTION project
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

import de.agilecoders.wicket.core.markup.html.bootstrap.dialog.Modal;
import eu.chorevolution.idm.common.to.ChoreographyTO;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Comparator;
import org.apache.syncope.client.console.commons.DirectoryDataProvider;
import org.apache.syncope.client.console.pages.ChoreographyPage;
import org.apache.syncope.client.console.pages.ChoreographyDetailPage;
import org.apache.syncope.client.console.panels.ChoreographyDirectoryPanel.ChoreographyProvider;
import org.apache.syncope.client.console.rest.ChoreographyRestClient;
import org.apache.syncope.client.console.wicket.markup.html.form.ActionLink;
import org.apache.syncope.client.console.wizards.WizardMgtPanel;
import org.apache.wicket.PageReference;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.extensions.ajax.markup.html.IndicatingAjaxLink;
import org.apache.wicket.extensions.markup.html.repeater.data.grid.ICellPopulator;
import org.apache.wicket.extensions.markup.html.repeater.data.table.AbstractColumn;
import org.apache.wicket.extensions.markup.html.repeater.data.table.IColumn;
import org.apache.wicket.extensions.markup.html.repeater.data.table.PropertyColumn;
import org.apache.wicket.markup.repeater.Item;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.ResourceModel;
import org.apache.wicket.request.mapper.parameter.PageParameters;

public class ChoreographyDirectoryPanel extends DirectoryPanel<
        ChoreographyTO, ChoreographyTO, ChoreographyProvider, ChoreographyRestClient> {

    private static final long serialVersionUID = 3727444742501082182L;

    public ChoreographyDirectoryPanel(final String id, final PageReference pageRef) {
        super(id, new Builder<ChoreographyTO, ChoreographyTO, ChoreographyRestClient>(
                new ChoreographyRestClient(), pageRef) {

            private static final long serialVersionUID = 8769126634538601689L;

            @Override
            protected WizardMgtPanel<ChoreographyTO> newInstance(final String id, final boolean wizardInModal) {
                return new ChoreographyDirectoryPanel(id, this);
            }
        }.disableCheckBoxes());

        setFooterVisibility(true);
        modal.addSubmitButton();
        modal.size(Modal.Size.Large);
        initResultTable();
    }

    private ChoreographyDirectoryPanel(
            final String id,
            final Builder<ChoreographyTO, ChoreographyTO, ChoreographyRestClient> builder) {

        super(id, builder);
    }

    @Override
    protected ChoreographyProvider dataProvider() {
        return new ChoreographyProvider(rows);
    }

    @Override
    protected String paginatorRowsKey() {
        return ChoreographyPage.PREF_CHOREOGRAPHY_PAGINATOR_ROWS;
    }

    @Override
    protected Collection<ActionLink.ActionType> getBulkActions() {
        return Collections.<ActionLink.ActionType>emptyList();
    }

    @Override
    protected List<IColumn<ChoreographyTO, String>> getColumns() {
        final List<IColumn<ChoreographyTO, String>> columns = new ArrayList<>();
        columns.add(new PropertyColumn<>(new ResourceModel("name"), "Name", "name"));
        columns.add(new PropertyColumn<>(new ResourceModel("description", "Description"), "description"));
        columns.add(new AbstractColumn<ChoreographyTO, String>(new ResourceModel("actions", "")) {

            private static final long serialVersionUID = -3503023501954863131L;

            @Override
            public String getCssClass() {
                return "action";
            }

            @Override
            public void populateItem(final Item<ICellPopulator<ChoreographyTO>> item, final String componentId,
                    final IModel<ChoreographyTO> model) {

                ChoreographyActionsPanel choreographyActionsPanel = new ChoreographyActionsPanel(componentId);

                choreographyActionsPanel.addAction(new IndicatingAjaxLink<Void>("link") {

                    private static final long serialVersionUID = 3104631231085231035L;

                    @Override
                    public void onClick(final AjaxRequestTarget target) {
                        PageParameters param = new PageParameters();
                        param.add("chor", model.getObject().getId());
                        setResponsePage(ChoreographyDetailPage.class, param);
                    }
                }, ChoreographyActionsPanel.ChoreographyActionType.SHOW);
                item.add(choreographyActionsPanel);
            }
        });

        return columns;
    }

    protected final class ChoreographyProvider extends DirectoryDataProvider<ChoreographyTO> {

        private static final long serialVersionUID = -185944053385660794L;

        private final Comparator<ChoreographyTO> comparator;

        private ChoreographyProvider(final int paginatorRows) {
            super(paginatorRows);
            comparator = new ChoreographyComparator();
        }

        @Override
        public Iterator<ChoreographyTO> iterator(final long first, final long count) {
            List<ChoreographyTO> choreographyList = restClient.choreographyList();
            Collections.sort(choreographyList, comparator);
            return choreographyList.subList((int) first, (int) first + (int) count).iterator();
        }

        @Override
        public long size() {
            return restClient.choreographyList().size();
        }

        @Override
        public IModel<ChoreographyTO> model(final ChoreographyTO object) {
            return new CompoundPropertyModel<>(object);
        }
    }

    protected static class ChoreographyComparator implements Comparator<ChoreographyTO>, Serializable {

        private static final long serialVersionUID = -5499388798554495465L;

        @Override
        public int compare(final ChoreographyTO o1, final ChoreographyTO o2) {
            return o1.getName().compareTo(o2.getName());
        }
    }
}
