fn factor(number: i32) -> Vec<i32> {
    let mut number = number;
    let mut factors = vec![];
    let mut candidate = 2;

    while number > 1 {
        while number % candidate == 0 {
            factors.push(candidate);
            number /= candidate;
        }
        candidate += 1;
    }

    factors
}

pub fn raindrops(number: i32) -> String {
    let factors = factor(number);

    let mut pling: bool = false;
    let mut plang: bool = false;
    let mut plong: bool = false;

    for n in factors {
        match n {
            3 => pling = true,
            5 => plang = true,
            7 => plong = true,
            _ => (),
        }
    }

    let mut output = String::new();
    if pling {
        output += "Pling";
    }
    if plang {
        output += "Plang";
    }
    if plong {
        output += "Plong";
    }

    if output.is_empty() {
        number.to_string()
    } else {
        output
    }

}
