public enum SaleState {
    ORDERED {
        @Override
        public String toString() {
            return "NEW";
        }
    },
    IN_THE_WAREHOUSE,
    SOLD
}
