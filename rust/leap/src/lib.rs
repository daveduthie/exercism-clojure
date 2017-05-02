pub fn is_leap_year(year: i32) -> bool {
    match year {
        _ if year % 4 != 0 => false,
        _ if year % 100 != 0 => true,
        _ => year % 400 == 0,
    }
}
