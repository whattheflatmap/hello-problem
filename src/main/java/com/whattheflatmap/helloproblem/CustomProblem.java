package com.whattheflatmap.helloproblem;

import org.zalando.problem.AbstractThrowableProblem;
import org.zalando.problem.Status;

public class CustomProblem extends AbstractThrowableProblem {

    public CustomProblem(Long itemId) {
        super(DEFAULT_TYPE,"Not found", Status.NOT_FOUND,
                String.format("Item '%s' not found", itemId));
    }
}
