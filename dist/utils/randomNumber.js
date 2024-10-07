export const generateRandomNum = () => {
    let random = new Set();
    while (random.size < 3) {
        const number = Math.floor(Math.random() * 9) + 1;
        random.add(number.toString());
    }
    return Array.from(random);
};
