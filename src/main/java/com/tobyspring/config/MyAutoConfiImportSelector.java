package com.tobyspring.config;

import org.springframework.beans.factory.BeanClassLoaderAware;
import org.springframework.boot.context.annotation.ImportCandidates;
import org.springframework.context.annotation.DeferredImportSelector;
import org.springframework.core.type.AnnotationMetadata;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.StreamSupport;

public class MyAutoConfiImportSelector implements DeferredImportSelector {

//    @Override
//    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
//        return new String[]{
//                "com.tobyspring.config.autoconfig.DispatcherServletConfig",
//                "com.tobyspring.config.autoconfig.TomcatWebServerConfig"
//        };
//    }

    private final ClassLoader classLoader;

    public MyAutoConfiImportSelector(ClassLoader classLoader) {
        this.classLoader = classLoader;
    }

    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {

        // 후보들을 읽어옴
//        Iterable<String> candidates = ImportCandidates.load(MyAutoConfiImportSelector.class, classLoader);
//        return StreamSupport.stream(candidates.spliterator(), false).toArray(String[]::new);

        List<String> autoconfigs = new ArrayList<>();

        ImportCandidates.load(MyAutoConfiImportSelector.class, classLoader).forEach(autoconfigs::add);
        System.out.println(autoconfigs);
        return autoconfigs.toArray(new String[0]);
//        return autoconfigs.stream().toArray(String[]::new);
//        return Arrays.copyOf(autoconfigs.toArray(), autoconfigs.size(), String[].class);

    }

}
