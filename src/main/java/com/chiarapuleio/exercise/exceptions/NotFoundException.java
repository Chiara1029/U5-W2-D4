package com.chiarapuleio.exercise.exceptions;

import java.util.UUID;

public class NotFoundException extends RuntimeException{

    public NotFoundException(){
        super("Item not found");
    }

    public NotFoundException(UUID id){
        super("Id " + id + " doesn't exist." );
    }
}
