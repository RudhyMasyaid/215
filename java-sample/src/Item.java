class Item {
    private int itemPrice; // Menyimpan harga barang sebagai int.
    private String itemName; // Menyimpan nama barang.
    private String itemCode; // Menyimpan kode barang.
    private int itemQty; // Menyimpan jumlah barang.

    public Item(String code, String name, int price, int qty) {
        // Konstruktor untuk menginisialisasi barang dengan kode, nama, harga, dan jumlah.
        this.itemCode = code;
        this.itemName = name;
        this.itemPrice = price;
        this.itemQty = qty;
    }

    public int getSubTotal() {
        // Menghitung subtotal barang (harga x jumlah) tanpa desimal.
        return itemPrice * itemQty;
    }

    public int getPrice() {
        return itemPrice; // Mengembalikan harga barang sebagai int.
    }

    public String getCode() {
        return itemCode; // Mengembalikan kode barang.
    }

    public String getName() {
        return itemName; // Mengembalikan nama barang.
    }

    public int getQty() {
        return itemQty; // Mengembalikan jumlah barang.
    }
}
