/*
 * Created on Dec 26, 2010
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
 * Copyright @2010-2011 the original author or authors.
 */
package org.assert4j.core.assertions.internal.throwables;

import static org.assert4j.core.assertions.error.ShouldHaveNoCause.shouldHaveNoCause;
import static org.assert4j.core.assertions.test.TestData.someInfo;
import static org.assert4j.core.util.FailureMessages.actualIsNull;


import static org.junit.Assert.fail;
import static org.mockito.Mockito.verify;

import org.assert4j.core.assertions.core.AssertionInfo;
import org.assert4j.core.assertions.internal.Throwables;
import org.assert4j.core.assertions.internal.ThrowablesBaseTest;
import org.junit.Test;


/**
 * Tests for <code>{@link Throwables#assertHasNoCause(AssertionInfo, Throwable, Class)}</code>.
 * 
 * @author Joel Costigliola
 */
public class Throwables_assertHasNoCause_Test extends ThrowablesBaseTest {

  @Test
  public void should_pass_if_actual_has_no_cause() {
    throwables.assertHasNoCause(someInfo(), actual);
  }

  @Test
  public void should_fail_if_actual_is_null() {
    thrown.expectAssertionError(actualIsNull());
    throwables.assertHasNoCause(someInfo(), null);
  }

  @Test
  public void should_fail_if_actual_has_a_cause() {
    AssertionInfo info = someInfo();
    Throwable throwableWithCause = new Throwable(new NullPointerException());
    try {
      throwables.assertHasNoCause(info, throwableWithCause);
      fail("AssertionError expected");
    } catch (AssertionError err) {
      verify(failures).failure(info, shouldHaveNoCause(throwableWithCause));
    }
  }
}