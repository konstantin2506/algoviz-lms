package ru.algoviz_lms.algo_impls.common;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class BasicJsonMapper implements  JsonMapper{

    private final ObjectMapper mapper;
    public BasicJsonMapper(){
        mapper = new ObjectMapper();
        mapper.addMixIn(Step.class, StepMixIn.class);
    }
    @Override
    public String convertToString(Object object) {

        try {
            return mapper.writeValueAsString(object);
        }catch (JsonProcessingException e){
            throw new JsonCreationException(e.getMessage());
        }
    }
}
