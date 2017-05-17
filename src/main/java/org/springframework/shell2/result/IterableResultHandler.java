/*
 * Copyright 2015 the original author or authors.
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

package org.springframework.shell2.result;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell2.ResultHandlers;
import org.springframework.stereotype.Component;

/**
 * A {@link ResultHandler} that deals with {@link Iterable}s and delegates to
 * {@link ResultHandlers} for each element in turn.
 *
 * @author Eric Bottard
 */
@Component
public class IterableResultHandler implements ResultHandler<Iterable> {

	private ResultHandlers resultHandlers;

	@Autowired
	public void setResultHandlers(ResultHandlers resultHandlers) {
		this.resultHandlers = resultHandlers;
	}

	@Override
	public void handleResult(Iterable result) {
		for (Object o : result) {
			resultHandlers.handleResult(o);
		}
	}
}