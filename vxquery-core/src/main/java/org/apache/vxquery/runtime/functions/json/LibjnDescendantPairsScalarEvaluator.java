/*
* Licensed to the Apache Software Foundation (ASF) under one or more
* contributor license agreements.  See the NOTICE file distributed with
* this work for additional information regarding copyright ownership.
* The ASF licenses this file to You under the Apache License, Version 2.0
* (the "License"); you may not use this file except in compliance with
* the License.  You may obtain a copy of the License at
*
*     http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
* See the License for the specific language governing permissions and
* limitations under the License.
*/
package org.apache.vxquery.runtime.functions.json;

import org.apache.hyracks.algebricks.runtime.base.IScalarEvaluator;
import org.apache.hyracks.api.context.IHyracksTaskContext;
import org.apache.hyracks.data.std.util.ArrayBackedValueStorage;
import org.apache.vxquery.datamodel.accessors.TaggedValuePointable;
import org.apache.vxquery.datamodel.accessors.jsonitem.ObjectPointable;
import org.apache.vxquery.datamodel.builders.jsonitem.ObjectBuilder;

import java.io.IOException;

public class LibjnDescendantPairsScalarEvaluator extends AbstractLibjnDescendantScalarEvaluator {

    private final ObjectBuilder ob;
    private final ArrayBackedValueStorage abvs1;

    public LibjnDescendantPairsScalarEvaluator(IHyracksTaskContext ctx, IScalarEvaluator[] args) {
        super(ctx, args);
        abvs1 = new ArrayBackedValueStorage();
        ob = new ObjectBuilder();
    }

    @Override
    protected void processPair(TaggedValuePointable tvp, ObjectPointable op) throws IOException {
        abvs1.reset();
        ob.reset(abvs1);
        tvp.getValue(stringp);
        op.getValue(stringp, tvp);
        ob.addItem(stringp, tvp);
        ob.finish();
        sb.addItem(abvs1);
    }
}
