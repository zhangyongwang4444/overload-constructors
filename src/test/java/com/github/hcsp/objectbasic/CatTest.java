package com.github.hcsp.objectbasic;

import com.github.hcsp.test.helper.JavaASTReader;
import com.github.javaparser.ast.stmt.ExplicitConstructorInvocationStmt;
import java.io.FileNotFoundException;
import java.util.UUID;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CatTest {
    @Test
    public void constructorIsCallable() {
        String name = UUID.randomUUID().toString();
        Cat cat = new Cat(name);

        Assertions.assertEquals(name, cat.name);
        Assertions.assertEquals(1, cat.age);
        Assertions.assertTrue(cat.cute);

        cat = new Cat(name, 2);
        Assertions.assertEquals(2, cat.age);
        Assertions.assertTrue(cat.cute);
    }

    @Test
    public void hasConstructorInvocationStatement() throws FileNotFoundException {
        JavaASTReader.assertContains(Cat.class, ExplicitConstructorInvocationStmt.class);
    }
}
