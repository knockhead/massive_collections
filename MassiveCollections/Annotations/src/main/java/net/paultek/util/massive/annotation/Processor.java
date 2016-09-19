/*
 * Copyright 2016 Paul Huynh [paul.viet.huynh@live.com].
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
package net.paultek.util.massive.annotation;

import java.io.IOException;
import java.io.Writer;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.Filer;
import javax.annotation.processing.Messager;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.annotation.processing.SupportedSourceVersion;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.ElementKind;
import javax.lang.model.element.TypeElement;
import javax.tools.Diagnostic;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;

/**
 * This processor handles the generation of code from interfaces.
 *
 * @author Paul Huynh [paul.viet.huynh@live.com]
 */
@SupportedAnnotationTypes(value = {
    "net.paultek.util.massive.annotation.GenerateCode"
})
@SupportedSourceVersion(SourceVersion.RELEASE_8)
public class Processor extends AbstractProcessor {

    // Public default constructor, in case reflective tools look for it
    public Processor() {
    }

    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
        final Set<? extends Element> elements = roundEnv.getElementsAnnotatedWith(GenerateCode.class);
        final Messager messager = processingEnv.getMessager();
        final Filer filer = processingEnv.getFiler();
        for (Element e : elements) {
            if (e.getKind() != ElementKind.INTERFACE) {
                messager.printMessage(Diagnostic.Kind.ERROR, GenerateCode.class.getSimpleName() + " can only be applied on interfaces", e);
            }
        }

        // Convert all the elements to TypeElements
        for (Element e : elements) {
            generateCode((TypeElement) e, filer);
        }

        return true;
    }

    protected void generateCode(TypeElement typeElement, Filer filer) {
        final VelocityEngine engine = new VelocityEngine();
        engine.init();
        final Template template = engine.getTemplate("generate_code_template.vm");

        final VelocityContext context = new VelocityContext();
        context.put("packageName", "net.paultek.util.massive");
        context.put("interfaceName", typeElement.getSimpleName().toString());

        try (Writer writer = filer.createSourceFile("Dummy").openWriter()) {
            template.merge(context, writer);
        } catch (IOException ex) {
            Logger.getLogger(getClass().getSimpleName()).log(Level.SEVERE, null, ex);
        }
    }
}
