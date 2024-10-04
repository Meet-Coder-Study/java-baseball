export function shuffle(array: number[]) {
    for (let i = array.length - 1; i > 0; i--) {
        const j = Math.floor(Math.random() * (i + 1));
        [array[i], array[j]] = [array[j], array[i]];
    }
    return array;
}

export function generateRandomNumberString(min: number, max: number, length: number) {
    const numbers = Array.from({ length: max - min + 1 }, (_, i) => i + min);
    const shuffled = shuffle(numbers);
    return shuffled.slice(0, length).join('');
}
