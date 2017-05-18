/// Borrowing from @schodet and Gauss
pub fn square_of_sum(n: u64) -> u64 {
    let acc = (n + 1) * n / 2;
    acc * acc
}

/// Borrowing from @schodet again, as well as from:
/// https://trans4mind.com/personal_development/mathematics/series/sumNaturalSquares.htm
///
/// `sum_of_squares = (n^3)/3 + (n^2)/2 + n/6`
/// or `(2n^3 + 3n^2 + n) / 6`
pub fn sum_of_squares(n: u64) -> u64 {
    let cubic_term = 2 * n * n * n;
    let square_term = 3 * n * n;
    let linear_term = n;
    (cubic_term + square_term + linear_term) / 6
}

pub fn difference(n: u64) -> u64 {
    square_of_sum(n) - sum_of_squares(n)
}
