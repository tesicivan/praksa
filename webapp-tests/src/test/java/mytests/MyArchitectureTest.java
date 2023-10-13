package mytests;

import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import com.tngtech.archunit.lang.ArchRule;

import domainapp.modules.simple.SimpleModule;

import org.junit.jupiter.api.Test;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;
import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.noClasses;

public class MyArchitectureTest {

    @Test
    public void some_architecture_rule() {
        JavaClasses importedClasses = new ClassFileImporter().importClasses(SimpleModule.class);

        ArchRule rule = noClasses().that()
                        .resideInAPackage("..domainapp.modules.simple..")
                        .should()
                        .dependOnClassesThat()
                        .resideInAPackage("..mordor..");

        rule.check(importedClasses);
    }
}