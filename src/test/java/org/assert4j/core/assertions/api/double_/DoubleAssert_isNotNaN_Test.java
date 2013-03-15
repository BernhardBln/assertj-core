/*
 * Created on Jan 14, 2011
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with the
 * License. You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on an "AS IS"
 * BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the specific language
 * governing permissions and limitations under the License.
 * 
 * Copyright @2011 the original author or authors.
 */
package org.assert4j.core.assertions.api.double_;

import org.assert4j.core.assertions.api.DoubleAssert;
import org.assert4j.core.assertions.api.DoubleAssertBaseTest;

import static org.mockito.Mockito.verify;


/**
 * Tests for <code>{@link DoubleAssert#isNotNaN()}</code>.
 * 
 * @author Yvonne Wang
 */
public class DoubleAssert_isNotNaN_Test extends DoubleAssertBaseTest {

  @Override
  protected DoubleAssert invoke_api_method() {
    return assertions.isNotNaN();
  }

  @Override
  protected void verify_internal_effects() {
    verify(doubles).assertIsNotNaN(getInfo(assertions), getActual(assertions));
  }
}