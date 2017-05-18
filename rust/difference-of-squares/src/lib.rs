pub fn square_of_sum(n: u64) -> u64 {
    let mut acc: u64 = 0;
    for x in 1..(n + 1) {
        acc += x;
    }
    acc * acc
}

pub fn sum_of_squares(n: u64) -> u64 {
    let mut acc: u64 = 0;
    for x in 1..(n + 1) {
        acc += x * x;
    }
    acc
}

pub fn difference(n: u64) -> u64 {
    square_of_sum(n) - sum_of_squares(n)
}
