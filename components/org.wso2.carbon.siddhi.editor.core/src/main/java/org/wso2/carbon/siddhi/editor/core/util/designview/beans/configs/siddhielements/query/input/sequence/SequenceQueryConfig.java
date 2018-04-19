/*
 * Copyright (c) 2018, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 *
 * WSO2 Inc. licenses this file to you under the Apache License,
 * Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package org.wso2.carbon.siddhi.editor.core.util.designview.beans.configs.siddhielements.query.input.sequence;

import org.wso2.carbon.siddhi.editor.core.util.designview.beans.configs.siddhielements.query.input.QueryInputConfig;
import org.wso2.carbon.siddhi.editor.core.util.designview.constants.query.QueryInputType;

import java.util.List;

/**
 * Represents a Sequence QueryInputConfig, for Siddhi Query
 */
public class SequenceQueryConfig extends QueryInputConfig {
    List<SequenceQueryEventConfig> events;

    public SequenceQueryConfig(List<SequenceQueryEventConfig> events) {
        super(QueryInputType.SEQUENCE.toString());
        this.events = events;
    }

    public List<SequenceQueryEventConfig> getEvents() {
        return events;
    }
}
