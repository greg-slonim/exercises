package com.gslonim.coding;

import org.junit.Test;

import java.util.Objects;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

public class XmlParser {
    private static final Character OPEN_BRACE = '<';
    private static final Character CLOSE_BRACE = '>';
    private static final Character FORWARD_SLASH = '/';

    @Test
    public void testTokenizer() {
        assertThat(XmlTokenizer.parseToken("</blah>"))
                .hasValue(XmlTokenizer.Token.from(XmlTokenizer.TokenType.CLOSE, "blah"));
        assertThat(XmlTokenizer.parseToken("<blah>"))
                .hasValue(XmlTokenizer.Token.from(XmlTokenizer.TokenType.OPEN, "blah"));
        assertThat(XmlTokenizer.parseToken("token"))
                .hasValue(XmlTokenizer.Token.from(XmlTokenizer.TokenType.TEXT, "token"));
    }

    private static final class XmlTokenizer {
        public static Optional<Token> getToken(String token) {
            return parseToken(token);
        }

        private static Optional<Token> parseToken(String token) {
            if (token.isEmpty()) {
                return Optional.empty();
            }

            if (token.charAt(0) == OPEN_BRACE && token.charAt(1) == FORWARD_SLASH) {
                String value = token.substring(token.indexOf(FORWARD_SLASH) + 1, token.indexOf(CLOSE_BRACE));
                return Optional.of(Token.from(TokenType.CLOSE, value));
            }

            if (token.charAt(0) == OPEN_BRACE) {
                String value = token.substring(token.indexOf(OPEN_BRACE) + 1, token.indexOf(CLOSE_BRACE));
                return Optional.of(Token.from(TokenType.OPEN, value));
            }

            return Optional.of(Token.from(TokenType.TEXT, token));
        }

        private static final class Token {
            private final TokenType tokenType;
            private final String value;

            private Token(TokenType tokenType, String value) {
                this.tokenType = tokenType;
                this.value = value;
            }

            public static Token from(TokenType type, String value) {
                return new Token(type, value);
            }

            @Override
            public boolean equals(Object o) {
                if (this == o) return true;
                if (o == null || getClass() != o.getClass()) return false;
                Token token = (Token) o;
                return tokenType == token.tokenType &&
                        value.equals(token.value);
            }

            @Override
            public int hashCode() {
                return Objects.hash(tokenType, value);
            }
        }

        private enum TokenType {
            OPEN, CLOSE, TEXT
        }
    }
}