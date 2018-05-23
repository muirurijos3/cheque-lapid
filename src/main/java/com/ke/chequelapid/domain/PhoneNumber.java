package com.ke.chequelapid.domain;


import java.io.IOException;
import javax.persistence.Embeddable;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import org.apache.commons.lang3.StringUtils;

@Embeddable
@JsonSerialize(using=PhoneNumber.PhoneNumberSerializer.class)
@JsonDeserialize(using=PhoneNumber.PhoneNumberDeserializer.class)
public class PhoneNumber {
    private String number;

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = PhoneNumberUtils.parsePhoneNumber(number);
    }//the dilemma

    protected PhoneNumber() {
    }

    public PhoneNumber(String number) {
        setNumber(number);
    }

    public static PhoneNumber parse ( String number ) {
        return StringUtils.isNotBlank(number) ? new PhoneNumber(number) : null;
    }

    @Override
    public String toString() {
        return number;
    }

    public static final PhoneNumber NONE = new PhoneNumber();

    static class PhoneNumberSerializer extends StdSerializer<PhoneNumber> {

        protected PhoneNumberSerializer() {
            super(PhoneNumber.class);
        }

        @Override
        public void serialize(PhoneNumber value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
            gen.writeString(value.getNumber());
        }
    }

    static class PhoneNumberDeserializer extends StdDeserializer<PhoneNumber> {

        public PhoneNumberDeserializer() {
            super(PhoneNumber.class);
        }

        @Override
        public PhoneNumber deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
            return new PhoneNumber(p.getValueAsString());
        }
    }

}
