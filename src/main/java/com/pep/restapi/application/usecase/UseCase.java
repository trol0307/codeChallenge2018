package com.pep.restapi.application.usecase;

public interface UseCase<T1,T2> {
    T2 execute(T1 request) throws UseCaseException;
}
