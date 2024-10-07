export const compareNumbers = (randomNumber: string[], num: string) => {
  let strike = 0;
  let ball = 0;

  [...num].forEach((element, index) => {
    if (randomNumber.includes(element)) {
      ball++;
    }
    if (element === randomNumber[index]) {
      strike++;
    }
  });

  return { strike, ball };
};
