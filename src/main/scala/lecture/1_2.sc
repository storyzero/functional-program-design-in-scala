def mapFun[T, U](xs: List[T], f: T => U): List[U] =
  for (x <- xs) yield f(x)

def flatMap[T, U](xs: List[T], f: T => Iterable[U]): List[U] =
  for (x <- xs; y <- f(x)) yield y

def filter[T](xs: List[T], p: T => Boolean): List[T] =
  for (x <- xs if p(x)) yield x

val e1 = List()
val e2 = List()
val e3 = List()
def f = ???

for (x <- e1) yield e2
e1.map(x => e2)

for (x <- e1 if f) yield e2
for (x <- e1.withFilter(x => f)) yield e2

for (x <- e1; y <- e2) yield e3
e1.flatMap(x => for (y <- e2) yield e3)

val n = 9

def isPrime(x: Int): Boolean = {
  true
}

for {
  i <- 1 until n
  j <- 1 until i
  if isPrime(i + j)
} yield (i, j)

(1 until n).flatMap(i =>
  (1 until i).withFilter(j => isPrime(i + j))
    .map(j => (i, j)))

