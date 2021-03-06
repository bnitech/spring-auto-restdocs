/*-
 * #%L
 * Spring Auto REST Docs Kotlin Web MVC Example Project
 * %%
 * Copyright (C) 2015 - 2019 Scalable Capital GmbH
 * %%
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
 * #L%
 */
package capital.scalable.restdocs.example

import org.springframework.context.annotation.Configuration
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer
import org.springframework.web.servlet.resource.PathResourceResolver

/**
 * Serve generated documentation at /docs.
 */
@Configuration
internal class StaticResourceConfiguration : WebMvcConfigurer {

    override fun addResourceHandlers(registry: ResourceHandlerRegistry) {
        registry.addResourceHandler("/docs/**")
                .addResourceLocations("classpath:/public/")
                .resourceChain(true)
                .addResolver(PathResourceResolver())
    }

    override fun addViewControllers(registry: ViewControllerRegistry) {
        registry.addViewController("/docs")
                .setViewName("forward:/docs/index.html")
    }
}
