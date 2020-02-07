package com.example.demo.optional;

import java.util.Optional;
import java.util.function.Supplier;

/**
 * 利用 Java 8 的 Optional 类型来预防 null 检查示例
 * 这两个解决方案可能没有传统 null 检查那么高的性能，不过在大多数情况下不会有太大问题
 *
 * @author ywb
 * @date 2020/2/7 17:15
 */
public class OptionalDemo {
    /**
     * 我们可以通过利用 Java 8 的 Optional 类型来摆脱所有这些 null 检查。
     * map 方法接收一个 Function 类型的 lambda 表达式，并自动将每个 function 的结果包装成一个 Optional 对象。
     * 这使我们能够在一行中进行多个 map 操作。Null 检查是在底层自动处理的。
     */
    private void avoidNullCheck() {
        Outer outer = new Outer(new Nested(new Inner("hello")));
        Optional.of(outer).map(Outer::getNested).map(Nested::getInner).map(Inner::getFoo).ifPresent(System.out::println);
    }

    /**
     * 利用一个 supplier 函数来解决嵌套路径的问题
     * 调用 obj.getNested().getInner().getFoo()) 可能会抛出一个 NullPointerException 异常。
     * 在这种情况下，该异常将会被捕获，而该方法会返回 Optional.empty()。
     */
    private void avoidNullCheck2() {
        Outer outer = new Outer(new Nested(new Inner("hello")));
        resolve(() -> outer.getNested().getInner().getFoo()).ifPresent(System.out::println);
    }

    public static <T> Optional<T> resolve(Supplier<T> resolver) {
        try {
            T result = resolver.get();
            return Optional.ofNullable(result);
        } catch (NullPointerException e) {
            return Optional.empty();
        }
    }

    class Outer {
        Nested nested;

        public Outer(Nested nested) {
            this.nested = nested;
        }

        Nested getNested() {
            return nested;
        }
    }

    class Nested {
        Inner inner;

        public Nested(Inner inner) {
            this.inner = inner;
        }

        Inner getInner() {
            return inner;
        }
    }

    class Inner {
        String foo;

        public Inner(String foo) {
            this.foo = foo;
        }

        String getFoo() {
            return foo;
        }
    }
}
