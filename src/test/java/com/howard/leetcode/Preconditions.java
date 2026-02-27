package com.howard.leetcode;

import javax.annotation.Nullable;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public final class Preconditions {
    /**
     * Ensures that the given object reference is not null. Upon violation, a {@code
     * NullPointerException} with no message is thrown.
     *
     * @param reference The object reference
     * @return The object reference itself (generically typed).
     * @throws NullPointerException Thrown, if the passed reference was null.
     */
    public static <T> T checkNotNull(@Nullable T reference) {
        if (reference == null)
            throw new NullPointerException();
        return reference;

    }

    /**
     * Ensure that the given Object reference is not null
     *
     * @param reference The object reference
     * @param msg       The message for the {@link NullPointerException}
     * @return The object reference itself (generically typed).
     * @throws NullPointerException
     */
    public static <T> T checkNotNull(@Nullable T reference, @Nullable String msg) {
        if (reference == null)
            throw new NullPointerException(String.valueOf(msg));
        return reference;
    }

    /**
     * @param condition if condition is false throw {@link IllegalStateException}
     * @throws IllegalStateException
     */
    public static void checkState(boolean condition) {
        if (!condition) {
            throw new IllegalStateException();
        }

    }

    /**
     * Ensures that the given index is valid for an array, list or string of the given size.
     *
     * @param index        index to check
     * @param size         size of the array, list or string
     * @param errorMessage The message for the {@code IndexOutOfBoundsException} that is thrown if
     *                     the check fails.
     * @throws IllegalArgumentException  Thrown, if size is negative.
     * @throws IndexOutOfBoundsException Thrown, if the index negative or greater than or equal to
     *                                   size
     */
    public static void checkElementIndex(int index, int size, @Nullable String errorMessage) {
        checkArgument(size >= 0, "Size was negative.");
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException(
                    String.valueOf(errorMessage) + " Index: " + index + ", Size: " + size);
        }
    }

    private static void checkArgument(boolean condition, String errMsg) {
        if (!condition) {
            throw new IllegalStateException(String.valueOf(errMsg));
        }
    }

    /**
     * Ensure that the index is not out of bounds
     * @param index
     * @param size
     */
    public static void checkElementIndex(int index,int size){
        checkArgument(size>=0,"Size was negative.");
        if(index<0||index>size){
              throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);

        }

    }
    public static void checkArrayNotEmpty(@Nullable String msg, @Nullable Object... args) {
        if (args == null) {
            throw new NullPointerException(String.valueOf(msg));
        }
    }

    /**
     * Ensure that the future has completed normally
     *
     * @param future
     * @throws IllegalStateException Thrown, if future has not completed or it has completed exception
     */
    public static void checkCompleteNormally(CompletableFuture<?> future) {
        checkState(future.isDone());
        if (future.isCompletedExceptionally()) {
            try {
                future.get();
            } catch (InterruptedException | ExecutionException e) {
                throw new IllegalStateException(e);
            }

        }

    }

}
