/**
 *  Licensed to the Apache Software Foundation (ASF) under one or more
 *  contributor license agreements.  See the NOTICE file distributed with
 *  this work for additional information regarding copyright ownership.
 *  The ASF licenses this file to You under the Apache License, Version 2.0
 *  (the "License"); you may not use this file except in compliance with
 *  the License.  You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package org.wicketTutorial.commons.bootstrap.layout;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;
import org.apache.wicket.markup.html.link.PopupSettings;
import org.apache.wicket.model.IModel;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.apache.wicket.util.string.Strings;
import org.wicketTutorial.commons.bootstrap.source.SourcesPage;

public class BootstrapBasePage extends WebPage
{
	
	public BootstrapBasePage() 
	{
		super();
	}

	public BootstrapBasePage(IModel<?> model) 
	{
		super(model);
	}

	public BootstrapBasePage(PageParameters parameters) 
	{
		super(parameters);
	}

	@Override
	protected void onInitialize() 
	{
		super.onInitialize();
		
		BookmarkablePageLink<Void> link = new BookmarkablePageLink<Void>("sources",
			SourcesPage.class, SourcesPage.generatePageParameters(this));
		add(link);

		PopupSettings settings = new PopupSettings("sources", PopupSettings.RESIZABLE);
		settings.setWidth(800);
		settings.setHeight(600);
		link.setPopupSettings(settings);
		
		final String packageName = getClass().getPackage().getName();
		add(new Label("mainNavigation", Strings.afterLast(packageName, '.')));
	}
}
