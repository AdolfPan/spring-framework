/*
 * Copyright 2002-present the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.springframework.test.context.env.repeatable;

import org.junit.jupiter.api.extension.ExtendWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Abstract base class for integration tests involving
 * {@link TestPropertySource @TestPropertySource} as a repeatable annotation.
 *
 * @author Sam Brannen
 * @since 5.2
 */
@ExtendWith(SpringExtension.class)
@ContextConfiguration
abstract class AbstractRepeatableTestPropertySourceTests {

	@Autowired
	Environment env;


	protected void assertEnvironmentValue(String key, String expected) {
		assertThat(env.getProperty(key)).as("Value of key [" + key + "].").isEqualTo(expected);
	}


	@Configuration
	static class Config {
	}

}
