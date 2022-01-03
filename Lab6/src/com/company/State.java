package com.company;
//1
public enum State {
    NEW {
        @Override
        public String toString() {
            return "NEW";
        }

    },
    LATE {
        @Override
        public String toString() {
            return "LATE";
        }
    },

    PASSED {
        @Override
        public String toString() {
            return "PASSED";
        }
    },







}
