/*
 * Copyright 2017 George Aristy
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.llorllale.youtrack.api;

// @checkstyle AvoidStaticImport (2 lines)

import com.sun.org.apache.xpath.internal.SourceTree;
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import org.junit.BeforeClass;
import org.junit.Test;
import org.llorllale.youtrack.api.session.PermanentToken;
import org.llorllale.youtrack.api.session.Session;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Integration tests for {@link DefaultProjects}.
 *
 * @author George Aristy (george.aristy@gmail.com)
 * @checkstyle MethodName (500 lines)
 * @checkstyle AbbreviationAsWordInName (2 lines)
 * @since 0.6.0
 */
public final class ServiceIssues {
    private static IntegrationTestsConfig config;
    private static Session session;
    private static Projects projects;

    public static void setup() throws Exception {
        config = new IntegrationTestsConfig();
        session = new PermanentToken(
                config.youtrackUrl(),
                config.youtrackUserToken()
        ).login();
    }

    public static void main(String[] args) {
        try {
            setup();
            List<Project> projects = new ArrayList();
            List<Issue> issues = new ArrayList<>();
            final String service = "Požadavek - serviska";
            final String type = "Typ";
            projects = new DefaultYouTrack(session).projects().stream().collect(Collectors.toList());
            for (Project p : projects) {
                System.out.println(p.id());
                System.out.println(p.name());
                issues = p.issues().stream().collect(Collectors.toList());

                for (Issue issue : issues) {
                    Stream<AssignedField> assignedFields =  issue.fields().stream().filter(assignedField1 -> assignedField1.name().equals(type));

                    Optional<AssignedField> assignedField = assignedFields.findFirst();
                    if (assignedField.isPresent() && assignedField.get().value().asString().equals(service)) {
                        issue.timetracking().stream();
                        System.out.println(issue.id() + " "+ issue.timetracking().stream() + " " + assignedField.get().value().asString());
                   //     System.out.println(issue.id()); //assignedField.findFirst().get().value().asString());
                    }

//                 List<TimeTrackEntry> issueTimeTracking = issue.timetracking().stream().collect(Collectors.toList());

//                    for (TimeTrackEntry itt : issueTimeTracking) {
//                        System.out.println(itt.description() + " " + itt.duration() + " " + itt.date());
//                    }

                    }

                }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
