(: Licensed to the Apache Software Foundation (ASF) under one
   or more contributor license agreements.  See the NOTICE file
   distributed with this work for additional information
   regarding copyright ownership.  The ASF licenses this file
   to you under the Apache License, Version 2.0 (the
   "License"); you may not use this file except in compliance
   with the License.  You may obtain a copy of the License at
   
     http://www.apache.org/licenses/LICENSE-2.0
   
   Unless required by applicable law or agreed to in writing,
   software distributed under the License is distributed on an
   "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
   KIND, either express or implied.  See the License for the
   specific language governing permissions and limitations
   under the License. :)

(: JSONiq libjn:accumulate :)
libjn:accumulate(
        for $d at $i in ("Sunday",
        "Monday",
        "Tuesday",
        "Wednesday",
        "Thursday",
        "Friday",
        "Saturday" )
        return { $d : $i }
),
libjn:accumulate(({ "a": "b" }, { "c": "d" })),
libjn:accumulate(({ "a": "b" }, { "a": "d" })),
libjn:accumulate(
        (
                { "foo" : { "bar" : [ 1, 2 ] } },
                [ 1, 2, 3, 4 ],
                { "foo" : "bar", "bar" : "foo", "coa":123 , 456: 789},
                {"foo" : "bar", "coa" :123, 456 :"number"},
                1,
                jn:null()
        )
),
libjn:accumulate(({ "a": { "c": "d" } }, { "a": { "e": "f" } }))
