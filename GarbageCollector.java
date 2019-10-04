class GarbageCollector
{
        protected void finalize()
        {
                System.out.println("Cleaning Of Objects!");
        }
        public static void main(String[] args)
        {
                GarbageCollector gc1 = new GarbageCollector();
           
		GarbageCollector gc2 = new GarbageCollector();
                gc1 = null;
		gc2 = null;
                System.gc();
        }
}
