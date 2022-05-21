package io.meighen_bank_operationer.service.consumer;

import io.meighen_bank_operationer.model.KafkaMsg;

import java.io.IOException;
import java.text.ParseException;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@SpringBootTest
@ExtendWith(SpringExtension.class)
class CardsConsumerServiceTest {
    @Autowired
    private CardsConsumerService cardsConsumerService;

    /**
     * Method under test: {@link CardsConsumerService#consume(KafkaMsg)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testConsume() throws IOException, ParseException {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   com.fasterxml.jackson.core.JsonParseException: Unrecognized token 'Not': was expecting (JSON String, Number, Array, Object or token 'null', 'true' or 'false')
        //    at [Source: (String)"Not all who wander are lost"; line: 1, column: 4]
        //       at com.fasterxml.jackson.core.JsonParser._constructError(JsonParser.java:2391)
        //       at com.fasterxml.jackson.core.base.ParserMinimalBase._reportError(ParserMinimalBase.java:745)
        //       at com.fasterxml.jackson.core.json.ReaderBasedJsonParser._reportInvalidToken(ReaderBasedJsonParser.java:2961)
        //       at com.fasterxml.jackson.core.json.ReaderBasedJsonParser._reportInvalidToken(ReaderBasedJsonParser.java:2939)
        //       at com.fasterxml.jackson.core.json.ReaderBasedJsonParser._matchToken(ReaderBasedJsonParser.java:2713)
        //       at com.fasterxml.jackson.core.json.ReaderBasedJsonParser._handleOddValue(ReaderBasedJsonParser.java:1979)
        //       at com.fasterxml.jackson.core.json.ReaderBasedJsonParser.nextToken(ReaderBasedJsonParser.java:802)
        //       at com.fasterxml.jackson.databind.ObjectMapper._initForReading(ObjectMapper.java:4761)
        //       at com.fasterxml.jackson.databind.ObjectMapper._readMapAndClose(ObjectMapper.java:4667)
        //       at com.fasterxml.jackson.databind.ObjectMapper.readValue(ObjectMapper.java:3629)
        //       at com.fasterxml.jackson.databind.ObjectMapper.readValue(ObjectMapper.java:3597)
        //       at io.meighen_bank_operationer.service.consumer.CardsConsumerService.consume(CardsConsumerService.java:27)
        //   In order to prevent consume(KafkaMsg)
        //   from throwing JsonParseException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   consume(KafkaMsg).
        //   See https://diff.blue/R013 to resolve this issue.

        this.cardsConsumerService.consume(new KafkaMsg("Not all who wander are lost"));
    }

    /**
     * Method under test: {@link CardsConsumerService#consume(KafkaMsg)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testConsume2() throws IOException, ParseException {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   com.fasterxml.jackson.core.JsonParseException: Unrecognized token 'Body': was expecting (JSON String, Number, Array, Object or token 'null', 'true' or 'false')
        //    at [Source: (String)"Body"; line: 1, column: 5]
        //       at com.fasterxml.jackson.core.JsonParser._constructError(JsonParser.java:2391)
        //       at com.fasterxml.jackson.core.base.ParserMinimalBase._reportError(ParserMinimalBase.java:745)
        //       at com.fasterxml.jackson.core.json.ReaderBasedJsonParser._reportInvalidToken(ReaderBasedJsonParser.java:2961)
        //       at com.fasterxml.jackson.core.json.ReaderBasedJsonParser._handleOddValue(ReaderBasedJsonParser.java:2002)
        //       at com.fasterxml.jackson.core.json.ReaderBasedJsonParser.nextToken(ReaderBasedJsonParser.java:802)
        //       at com.fasterxml.jackson.databind.ObjectMapper._initForReading(ObjectMapper.java:4761)
        //       at com.fasterxml.jackson.databind.ObjectMapper._readMapAndClose(ObjectMapper.java:4667)
        //       at com.fasterxml.jackson.databind.ObjectMapper.readValue(ObjectMapper.java:3629)
        //       at com.fasterxml.jackson.databind.ObjectMapper.readValue(ObjectMapper.java:3597)
        //       at io.meighen_bank_operationer.service.consumer.CardsConsumerService.consume(CardsConsumerService.java:27)
        //   In order to prevent consume(KafkaMsg)
        //   from throwing JsonParseException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   consume(KafkaMsg).
        //   See https://diff.blue/R013 to resolve this issue.

        this.cardsConsumerService.consume(new KafkaMsg("Body"));
    }

    /**
     * Method under test: {@link CardsConsumerService#consume(KafkaMsg)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testConsume3() throws IOException, ParseException {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   com.fasterxml.jackson.databind.exc.MismatchedInputException: Cannot deserialize value of type `java.util.LinkedHashMap<java.lang.Object,java.lang.Object>` from Integer value (token `JsonToken.VALUE_NUMBER_INT`)
        //    at [Source: (String)"42"; line: 1, column: 1]
        //       at com.fasterxml.jackson.databind.exc.MismatchedInputException.from(MismatchedInputException.java:59)
        //       at com.fasterxml.jackson.databind.DeserializationContext.reportInputMismatch(DeserializationContext.java:1741)
        //       at com.fasterxml.jackson.databind.DeserializationContext.handleUnexpectedToken(DeserializationContext.java:1515)
        //       at com.fasterxml.jackson.databind.DeserializationContext.handleUnexpectedToken(DeserializationContext.java:1462)
        //       at com.fasterxml.jackson.databind.deser.std.MapDeserializer.deserialize(MapDeserializer.java:450)
        //       at com.fasterxml.jackson.databind.deser.std.MapDeserializer.deserialize(MapDeserializer.java:32)
        //       at com.fasterxml.jackson.databind.deser.DefaultDeserializationContext.readRootValue(DefaultDeserializationContext.java:322)
        //       at com.fasterxml.jackson.databind.ObjectMapper._readMapAndClose(ObjectMapper.java:4674)
        //       at com.fasterxml.jackson.databind.ObjectMapper.readValue(ObjectMapper.java:3629)
        //       at com.fasterxml.jackson.databind.ObjectMapper.readValue(ObjectMapper.java:3597)
        //       at io.meighen_bank_operationer.service.consumer.CardsConsumerService.consume(CardsConsumerService.java:27)
        //   In order to prevent consume(KafkaMsg)
        //   from throwing MismatchedInputException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   consume(KafkaMsg).
        //   See https://diff.blue/R013 to resolve this issue.

        this.cardsConsumerService.consume(new KafkaMsg("42"));
    }

    /**
     * Method under test: {@link CardsConsumerService#consume(KafkaMsg)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testConsume4() throws IOException, ParseException {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   com.fasterxml.jackson.databind.exc.MismatchedInputException: No content to map due to end-of-input
        //    at [Source: (String)""; line: 1, column: 0]
        //       at com.fasterxml.jackson.databind.exc.MismatchedInputException.from(MismatchedInputException.java:59)
        //       at com.fasterxml.jackson.databind.ObjectMapper._initForReading(ObjectMapper.java:4765)
        //       at com.fasterxml.jackson.databind.ObjectMapper._readMapAndClose(ObjectMapper.java:4667)
        //       at com.fasterxml.jackson.databind.ObjectMapper.readValue(ObjectMapper.java:3629)
        //       at com.fasterxml.jackson.databind.ObjectMapper.readValue(ObjectMapper.java:3597)
        //       at io.meighen_bank_operationer.service.consumer.CardsConsumerService.consume(CardsConsumerService.java:27)
        //   In order to prevent consume(KafkaMsg)
        //   from throwing MismatchedInputException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   consume(KafkaMsg).
        //   See https://diff.blue/R013 to resolve this issue.

        this.cardsConsumerService.consume(new KafkaMsg(""));
    }

    /**
     * Method under test: {@link CardsConsumerService#consume(KafkaMsg)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testConsume5() throws IOException, ParseException {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.IllegalArgumentException: argument "content" is null
        //       at com.fasterxml.jackson.databind.ObjectMapper._assertNotNull(ObjectMapper.java:4829)
        //       at com.fasterxml.jackson.databind.ObjectMapper.readValue(ObjectMapper.java:3596)
        //       at io.meighen_bank_operationer.service.consumer.CardsConsumerService.consume(CardsConsumerService.java:27)
        //   In order to prevent consume(KafkaMsg)
        //   from throwing IllegalArgumentException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   consume(KafkaMsg).
        //   See https://diff.blue/R013 to resolve this issue.

        this.cardsConsumerService.consume(new KafkaMsg());
    }

    /**
     * Method under test: {@link CardsConsumerService#consume(KafkaMsg)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testConsume6() throws IOException, ParseException {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   com.fasterxml.jackson.core.JsonParseException: Unexpected character ('N' (code 78)): Expected space separating root-level values
        //    at [Source: (String)"42Not all who wander are lost"; line: 1, column: 4]
        //       at com.fasterxml.jackson.core.JsonParser._constructError(JsonParser.java:2391)
        //       at com.fasterxml.jackson.core.base.ParserMinimalBase._reportError(ParserMinimalBase.java:735)
        //       at com.fasterxml.jackson.core.base.ParserMinimalBase._reportUnexpectedChar(ParserMinimalBase.java:659)
        //       at com.fasterxml.jackson.core.base.ParserMinimalBase._reportMissingRootWS(ParserMinimalBase.java:707)
        //       at com.fasterxml.jackson.core.json.ReaderBasedJsonParser._verifyRootSpace(ReaderBasedJsonParser.java:1750)
        //       at com.fasterxml.jackson.core.json.ReaderBasedJsonParser._parsePosNumber(ReaderBasedJsonParser.java:1383)
        //       at com.fasterxml.jackson.core.json.ReaderBasedJsonParser.nextToken(ReaderBasedJsonParser.java:799)
        //       at com.fasterxml.jackson.databind.ObjectMapper._initForReading(ObjectMapper.java:4761)
        //       at com.fasterxml.jackson.databind.ObjectMapper._readMapAndClose(ObjectMapper.java:4667)
        //       at com.fasterxml.jackson.databind.ObjectMapper.readValue(ObjectMapper.java:3629)
        //       at com.fasterxml.jackson.databind.ObjectMapper.readValue(ObjectMapper.java:3597)
        //       at io.meighen_bank_operationer.service.consumer.CardsConsumerService.consume(CardsConsumerService.java:27)
        //   In order to prevent consume(KafkaMsg)
        //   from throwing JsonParseException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   consume(KafkaMsg).
        //   See https://diff.blue/R013 to resolve this issue.

        this.cardsConsumerService.consume(new KafkaMsg("42Not all who wander are lost"));
    }
}

