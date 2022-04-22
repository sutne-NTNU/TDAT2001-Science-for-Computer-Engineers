function res = ElektriskStromtetthet(J, n, q, v_d)
if J == 0
	res = n*q*v_d;
elseif n == 0
	res = J/(q*v_d);
elseif q == 0
	res = J/(n*v_d);
elseif v_d == 0
	res = J/(q*n);
end

