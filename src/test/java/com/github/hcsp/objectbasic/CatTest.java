
package com.github.hcsp.objectbasic;
org.junit.jupiter.api.Test;;com.github.hcsp.test.helper.JavaASTReader;

class CatTest {
@Test
public void constructorIsCallable() {
    String name = UUID.randomUUID().toString();
    Cat cat = new Cat(name);

    assertEquals(name, cat.name);
    assertEquals(1, cat.age);
    assertTrue(cat.cute);

    cat = new Cat(name, 2);
    assertEquals(2, cat.age);
    assertTrue(cat.cute);
}

@Test
public void hasConstructorInvocationStatement() throws FileNotFoundException {
  com.github.hcsp.test.helper.JavaASTReader.assertContains(Cat.class, com.github.javaparser.ast.stmt.ExplicitConstructorInvocationStmt.class);
}

}
