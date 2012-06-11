package org.apache.solr.analysis;

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

import java.io.Reader;
import java.io.StringReader;

import org.apache.lucene.analysis.BaseTokenStreamTestCase;
import org.apache.lucene.analysis.MockTokenizer;
import org.apache.lucene.analysis.TokenStream;

/**
 * Simple tests to ensure the Norwegian Minimal stem factory is working.
 */
public class TestNorwegianMinimalStemFilterFactory extends BaseTokenStreamTestCase {
  public void testStemming() throws Exception {
    Reader reader = new StringReader("eple eplet epler eplene eplets eplenes");
    NorwegianMinimalStemFilterFactory factory = new NorwegianMinimalStemFilterFactory();
    TokenStream stream = factory.create(new MockTokenizer(reader, MockTokenizer.WHITESPACE, false));
    assertTokenStreamContents(stream, new String[] { "epl", "epl", "epl", "epl", "epl", "epl" });
  }
}
