/*
 * Copyright 2002-2011 the original author or authors.
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

package org.cloudfoundry.workers.stocks.batch;


import org.cloudfoundry.runtime.env.CloudEnvironment;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Launches a batch job for a given date.
 *
 * @author Josh Long (josh.long@springsource.com)
 */
public class Main {
    public static void main (String [] args)   throws Throwable {
    	AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext();
    	annotationConfigApplicationContext.getEnvironment().setActiveProfiles(isCloudFoundry() ? "cloud" : "local");
    	annotationConfigApplicationContext.scan(BatchConfiguration.class.getPackage().getName());
    	annotationConfigApplicationContext.refresh();
    }

    private static boolean isCloudFoundry() {
    	 CloudEnvironment ce = new CloudEnvironment();
    	 return (ce.isCloudFoundry());
    }

}
