I added solutions for interview questions, also there is a question which is why java prohibits creation of generic arrays, the answer which I created is below.

Java prohibits the creation of generic arrays due to issues related to type safety and the way generics are implemented using type erasure. Here’s a detailed explanation:

1. Type Erasure
Generics in Java are implemented using a mechanism called type erasure. This means that generic type information is erased at runtime and replaced with raw types. For example, List<String> and List<Integer> both become List at runtime. This allows for backward compatibility with older versions of Java that do not support generics.

2. Array Covariance
Arrays in Java are covariant. This means that if Integer is a subtype of Number, then Integer[] is considered a subtype of Number[]. This can lead to potential runtime type errors. For example:

3. Incompatibility with Generics
Combining the type erasure of generics and the covariance of arrays can create situations where type safety is compromised. Consider the following example:

4. Lack of Reification
Java generics do not support reification, which means generic type information is not available at runtime. Without reification, the runtime type of the array elements is not known, which makes it impossible to enforce type safety for generic arrays. This is different from arrays, which do have their component type information available at runtime.

Summary
The prohibition of generic array creation in Java is primarily to prevent potential runtime type safety issues. By disallowing this, Java maintains a stricter type checking mechanism, ensuring that type errors are caught at compile time rather than at runtime. This decision is a consequence of the combination of type erasure, array covariance, and the lack of runtime type information for generics.
