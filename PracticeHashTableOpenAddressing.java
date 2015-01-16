public class PracticeHashMapOpenAddressing{

	private class HashEntry{
		private Object key;
		private Object value;

		HashEntry(Object key, Object value) {
			this.key = key;
			this.value = value;
		}

		public Object getValue() {
			return value;
		}

		public void setValue(int value) {
			this.value = value;
		}

		public Object getKey() {
			return key;
		}
	}

	private class DeletedEntry extends HashEntry {
		private static DeletedEntry entry = null;

		private DeletedEntry() {
			super(-1, -1);
		}

		public static DeletedEntry getUniqueDeletedEntry() {
			if (entry == null)
				entry = new DeletedEntry();
			return entry;
		}
	}

	private final static int TABLE_SIZE = 128;

	HashEntry[] table;

	HashMap() {
		table = new HashEntry[TABLE_SIZE];
		for (int i = 0; i < TABLE_SIZE; i++){
			table[i] = null;
		}
	}

	public int get(int key){
		int hash = hashFunction(key);
		


	}
	public void put(int key, int value){
		int hash = hashFunction(key);
		int initialHash = -1;

	}

	public int hashFunction(Object key){
		String intputString = key.toString().toLowerCase();
		char[] characters = inputString.toCharArray();
		for(int i = 0; i < characters.length; i++){
			char currentChar = characters[i];

			int j = (int)currentChar;
			result += j;
		}

		return ( result%TABLE_SIZE);
	}
}