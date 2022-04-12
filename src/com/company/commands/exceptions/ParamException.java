package com.company.commands.exceptions;

public class ParamException extends CommandException {
    public ParamException() {
        super("Некорректные параметры");
    }
}
